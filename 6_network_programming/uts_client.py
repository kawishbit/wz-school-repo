import socket
import config

def send_command(command):
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    client_socket.connect(config.ADDRESS)

    client_socket.sendall(command.encode(config.FORMAT))

    output = client_socket.recv(config.BUFF_SIZE).decode(config.FORMAT)

    print(f'Command Output:\n{output}')

    config.client_close(client_socket)


if __name__ == '__main__':
    command = input("Enter a command: ")
    send_command(command)