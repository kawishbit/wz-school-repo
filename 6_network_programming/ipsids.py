from scapy.all import *

SUSPICIOUS_IP = "192.168.1.100"
def packet_callback(packet):
    print(packet[TCP])
    if packet.haslayer(TCP) or packet.haslayer(UDP):
        src_ip = "127.0.0.1"
        dst_ip = "127.0.0.1"
        # if packet.hasLayer(IP):
        #     src_ip = packet[IP].src
        #     dst_ip = packet[IP].dst
        src_port = packet.sport
        dst_port = packet.dport

        print(f"Alert: Suspicious packet detected!")
        print(f"Source IP: {src_ip}, Source Port: {src_port}")
        print(f"Destination IP: {dst_ip}, Destination Port: {dst_port}")
        print(f"Packet Summary: {packet.summary()}\n")
        if src_ip == SUSPICIOUS_IP:
            print("Blocking traffic from suspicious IP...")
            drop_packet(packet)

def drop_packet(packet):
    send(IP(src=packet[IP].dst, dst=packet[IP].src) / ICMP(type=3, code=3), verbose=0)
    
def main():
    print("Starting IDS...")
    sniff(prn=packet_callback, store=0, iface="lo")

if __name__ == "__main__":
    main()