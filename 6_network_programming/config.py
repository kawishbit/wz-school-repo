import socket 

PORT = 8080
SERVER = 'localhost'
ADDRESS = (SERVER, PORT)
FORMAT = 'utf-8'
BUFF_SIZE = 2048

def client_close(client_socket):
    client_socket.shutdown(socket.SHUT_RDWR)
    client_socket.close()
    print ("Client Closed")

def server_close(server_socket):
    server_socket.shutdown(socket.SHUT_RDWR)
    server_socket.close()
    print ("Server Closed")