import socket

# Constants for the NIDS/NIPS
TARGET_IP = "127.0.0.1"  # Change this to the target IP or subnet you want to monitor
PORT_SCAN_THRESHOLD = 5  # Number of connection attempts to consider as a port scan

# Dictionary to store the IP addresses and their connection counts
connection_counts = {}

def nids():
    # NIDS: Network Intrusion Detection System
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((TARGET_IP, 8080))
        s.listen(5)
        print("[NIDS] Listening for incoming connections...")
        while True:
            conn, addr = s.accept()
            print(f"[NIDS] Connection from: {addr}")
            ip_address = addr[0]
            if ip_address not in connection_counts:
                connection_counts[ip_address] = 0
            connection_counts[ip_address] += 1
            
            if connection_counts[ip_address] >= PORT_SCAN_THRESHOLD:
                print(f"[NIDS] Detected possible port scanning from: {ip_address}")
                # Call the NIPS to block the IP address
                nips_block_ip(ip_address)
            
def nips_block_ip(ip_address):
    # NIPS: Network Intrusion Prevention System
    print(f"[NIPS] Blocking IP address: {ip_address}")
    # In a real NIPS, you would perform actions like modifying firewall rules or blocking the IP at the network level.
    # For this example, we'll simply print the action taken.

if __name__ == "__main__":
    nids()