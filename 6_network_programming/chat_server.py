import threading
import socket
import os
import config


class Server(threading.Thread):
    def __init__(self, host, port):
        super().__init__()
        self.clients = []
        self.host = host
        self.port = port
    
    def run(self):
        server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server_socket.bind((self.host, self.port))

        server_socket.listen(1)
        print('Listening at', server_socket.getsockname())

        while True:
            
            client_socket, client_address = server_socket.accept()
            print('Accepted a new connection from {} to {}'.format(client_socket.getpeername(), client_socket.getsockname()))
            
            client_thread = ClientThread(client_socket, client_address, self)
            client_thread.start()

            self.clients.append(client_thread)
            print('Ready to receive messages from', client_socket.getpeername())

    def broadcast(self, message, source):
        for client in self.clients:
            if client.client_address != source:
                client.send(message)
    
    def remove_connection(self, client):
        self.clients.remove(client)


class ClientThread(threading.Thread):
    def __init__(self, client_socket, client_address, server):
        super().__init__()
        self.client_socket = client_socket
        self.client_address = client_address
        self.server = server
    
    def run(self):
        try:
            while True:
                message = self.client_socket.recv(config.BUFF_SIZE).decode(config.FORMAT)
                if message:
                    print('{} says {!r}'.format(self.client_address, message))
                    self.server.broadcast(message, self.client_address)
                else:
                    print('{} has closed the connection'.format(self.client_address))
                    self.client_socket.close()
                    server.remove_connection(self)
                    return
        except:
            print("An existing connection was forcibly closed by the remote host")
            self.client_socket.close()
            server.remove_connection(self)
            return
    
    def send(self, message):
        self.client_socket.sendall(message.encode(config.FORMAT))


def exit(server):
    try:
        while True:
            ipt = input('')
            if ipt == 'q':
                print('Closing all connections...')
                for client in server.clients:
                    client.client_socket.close()
                print('Shutting down the server...')
                os._exit(0)
    except:
        print("An existing connection was forcibly closed by the remote host")


if __name__ == '__main__':
    server = Server(config.SERVER, config.PORT)
    server.start()

    exit = threading.Thread(target = exit, args = (server,))
    exit.start()