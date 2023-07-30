from scapy.all import sniff, IP, TCP, ICMP
from collections import defaultdict
import time

# Define the threshold for detecting flooding attacks
THRESHOLD = 100

# Time window (in seconds) to check for packet frequency
TIME_WINDOW = 10

# Dictionary to store packet count for each source IP
packet_count = defaultdict(int)

def detect_flooding(pkt):
    global packet_count

    if IP in pkt:
        src_ip = pkt[IP].src

        # Update the packet count for the source IP
        packet_count[src_ip] += 1

        # Check if the packet count exceeds the threshold within the time window
        current_time = int(time.time())
        # for ip, count in packet_count.copy().items():
        #     if current_time - packet_count[ip][0] > TIME_WINDOW:
        #         del packet_count[ip]

        if packet_count[src_ip] > THRESHOLD:
            print(f"Flooding attack detected from {src_ip}. Packets: {packet_count[src_ip]}")

# Sniff packets and call detect_flooding for each packet
sniff(prn=detect_flooding, filter="icmp or (tcp and (tcp[13] == 2 or tcp[13] == 18))")