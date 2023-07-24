import socket

def port_scan():
    # Client: Simulated malicious activity (port scanning)
    target_ip = "127.0.0.1"  # Change this to the target IP you want to scan
    target_ports = [21, 22, 80, 443, 8080, 8888]  # Ports to scan

    for port in target_ports:
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
            try:
                s.settimeout(1)
                s.connect((target_ip, port))
                print(f"Port {port} is open.")
            except socket.error:
                print(f"Port {port} is closed.")

if __name__ == "__main__":
    port_scan()