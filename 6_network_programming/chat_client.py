import threading
import socket
import os
import sys
import config
import tkinter as tk


def focus_out_entry_box(widget, widget_text):
    widget.delete(0, tk.END)
    widget.insert(0, widget_text)


def focus_in_entry_box(widget):
    widget.delete(0, tk.END)

class Send(threading.Thread):
    def __init__(self, client_socket, name):
        super().__init__()
        self.client_socket = client_socket
        self.name = name

    def run(self):
        while True:
            print('{}: '.format(self.name), end='')
            sys.stdout.flush()
            message = sys.stdin.readline()[:-1]

            if message == 'QUIT':
                self.client_socket.sendall('Server: {} has left the chat.'.format(self.name).encode(config.FORMAT))
                break
            else:
                self.client_socket.sendall('{}: {}'.format(self.name, message).encode(config.FORMAT))
        
        print('\nQuitting...')
        self.client_socket.close()
        os._exit(0)


class Receive(threading.Thread):
    def __init__(self, client_socket, name):
        super().__init__()
        self.client_socket = client_socket
        self.name = name
        self.messages = None

    def run(self):
        while True:
            message = self.client_socket.recv(config.BUFF_SIZE).decode(config.FORMAT)

            if message:

                if self.messages:
                    self.messages.insert(tk.END, message)
                    print('hi')
                    print('\r{}\n{}: '.format(message, self.name), end = '')
                
                else:
                    print('\r{}\n{}: '.format(message, self.name), end = '')
            
            else:
                print('\nOh no, we have lost connection to the server!')
                print('\nQuitting...')
                self.client_socket.close()
                os._exit(0)

class Client:
    def __init__(self, host, port):
        self.host = host
        self.port = port
        self.client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.name = None
        self.messages = None
    
    def start(self):
        print('Trying to connect to {}:{}...'.format(self.host, self.port))
        self.client_socket.connect((self.host, self.port))
        print('Successfully connected to {}:{}'.format(self.host, self.port))
        
        print()
        self.name = input('Your name: ')

        print()
        print('Welcome, {}! Getting ready to send and receive messages...'.format(self.name))

        send = Send(self.client_socket, self.name)
        receive = Receive(self.client_socket, self.name)

        send.start()
        receive.start()

        self.client_socket.sendall('Server: {} has joined the chat. Say hi!'.format(self.name).encode(config.FORMAT))
        print("\rAll set! Leave the chatroom anytime by typing 'QUIT'\n")
        print('{}: '.format(self.name), end = '')

        return receive

    def send(self, text_input):
        message = text_input.get()
        text_input.delete(0, tk.END)
        self.messages.insert(tk.END, '{}: {}'.format(self.name, message))

        if message == 'QUIT':
            self.client_socket.sendall('Server: {} has left the chat.'.format(self.name).encode(config.FORMAT))
            
            print('\nQuitting...')
            self.client_socket.close()
            os._exit(0)
        
        else:
            self.client_socket.sendall('{}: {}'.format(self.name, message).encode(config.FORMAT))


def main(host, port):
    client = Client(host, port)
    receive = client.start()

    window = tk.Tk()
    window.title(f'Chatroom {client.name}')

    frm_messages = tk.Frame(master=window)
    scrollbar = tk.Scrollbar(master=frm_messages)
    messages = tk.Listbox(
        master=frm_messages, 
        font='Arial 12',
        yscrollcommand=scrollbar.set
    )
    scrollbar.pack(side=tk.RIGHT, fill=tk.Y, expand=False)
    messages.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
    
    client.messages = messages
    receive.messages = messages

    frm_messages.grid(row=0, column=0, columnspan=2, sticky="nsew")

    frm_entry = tk.Frame(master=window)
    text_input = tk.Entry(master=frm_entry, font='Arial 12')
    text_input.insert(0, "Your message here.")
    text_input.bind("<FocusIn>", lambda args: focus_in_entry_box(text_input))
    text_input.bind("<FocusOut>", lambda args: focus_out_entry_box(text_input, "Your message here."))
    text_input.bind("<Return>", lambda x: client.send(text_input))
    text_input.pack(fill=tk.BOTH, expand=True)

    btn_send = tk.Button(
        master=window,
        text='Send',
        command=lambda: client.send(text_input)
    )

    frm_entry.grid(row=1, column=0, padx=10, sticky="ew")
    btn_send.grid(row=1, column=1, pady=10, sticky="ew")

    window.rowconfigure(0, minsize=500, weight=1)
    window.rowconfigure(1, minsize=50, weight=0)
    window.columnconfigure(0, minsize=500, weight=1)
    window.columnconfigure(1, minsize=200, weight=0)

    window.mainloop()


if __name__ == '__main__':
    main(config.SERVER, config.PORT)