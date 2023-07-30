from scapy.all import *
from collections import Counter
from time import localtime, strftime
from sys import platform
import threading
import os 


attack_flag = False
syn_count = Counter()

print("Platform: {0}".format(platform))

class ClearCacheThread(threading.Thread):

    def run(self):

        global attack_flag

        while True:
            cur_time = strftime("%a, %d %b %Y %X", localtime())
            if attack_flag:
                src_ip = str(syn_count.most_common(1)[0][0])
                src_count = str(syn_count.most_common(1)[0][1])
                print("{0} Flood attack detected! IP: {1} | No. of attempts: {2}".format( cur_time, src_ip, src_count ))
                os.system("echo phoenixtron | sudo -S iptables -A INPUT -s {0} -p icmp --icmp-type echo-request -j DROP".format(src_ip))
                # subprocess.call(
                #     ["iptables", "-A", "INPUT", "-s", ip, "-j", "DROP"])
                # os.system('cmd /k "netsh advfirewall firewall add rule name=blockIcmp{0} dir=in action=block protocol=icmpv4:8,any source={1}"'.format(src_ip, src_ip))
                attack_flag = False
                syn_count.clear()
            time.sleep(3.5)


def flow_labels(packet):

    global attack_flag
    if IP in packet:
        ipsrc = str(packet[IP].src)
        ipdst = str(packet[IP].dst)
        try:
            sport = str(packet[IP].sport)
            dport = str(packet[IP].dport)
        except:
            sport = ""
            dport = ""
        prtcl = packet.getlayer(2).name

        flow = 'Name: {:<4} | Source IP: {:<16} | Source Port: {:<6} | Dest IP: {:<16} | Dest Port: {:<6} | '.format(prtcl, ipsrc, sport, ipdst, dport)
        print(flow)
    
    if ICMP in packet:
        src = packet.sprintf('{IP:%IP.src%}{IPv6:%IPv6.src%}')
        syn_count[src] += 1
        if syn_count.most_common(1)[0][1] > 10:
            attack_flag = True

    if TCP in packet and packet[TCP].flags & 2:
        src = packet.sprintf('{IP:%IP.src%}{IPv6:%IPv6.src%}')
        syn_count[src] += 1
        if syn_count.most_common(1)[0][1] > 10 and packet.ack == 0:
            attack_flag = True


ClearCacheThread().start()
sniff(prn=flow_labels, filter="icmp or (tcp and (tcp[13] == 2 or tcp[13] == 18))", store=0)