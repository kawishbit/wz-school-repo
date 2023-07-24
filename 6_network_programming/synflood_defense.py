from scapy.all import *
from collections import Counter
from time import localtime, strftime
import threading


attack_flag = False
syn_count = Counter()


class ClearCacheThread(threading.Thread):

    def run(self):

        global attack_flag

        while True:
            cur_time = strftime("%a, %d %b %Y %X", localtime())
            if not attack_flag or not syn_count:
                print(cur_time + " Everything is normal")
            else:
                print(cur_time + " SYN attack detected! IP: " + str(syn_count.most_common(1)[0][0]) + " No. of attempts: " + str(syn_count.most_common(1)[0][1]))
                attack_flag = False
            syn_count.clear()
            time.sleep(3.5)


def flow_labels(packet):

    global attack_flag

    print('IP in pkt: {0} | TCP in pkt: {1} | bitwise: {2} | syncount: {3}'.format(IP in packet, TCP in packet, TCP in packet and packet[TCP].flags & 2, syn_count['{IP:%IP.src%}{IPv6:%IPv6.src%}']))
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
    

    if TCP in packet and packet[TCP].flags & 2:
        src = packet.sprintf('{IP:%IP.src%}{IPv6:%IPv6.src%}')
        syn_count[src] += 1
        if syn_count.most_common(1)[0][1] > 25 and packet.ack == 0:
            attack_flag = True


ClearCacheThread().start()
sniff(prn=flow_labels, store=0)