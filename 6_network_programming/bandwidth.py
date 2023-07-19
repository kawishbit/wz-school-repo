import speedtest
import getmac
import socket
import urllib.request


def get_internet_bandwidth():
    st = speedtest.Speedtest()
    download_speed = st.download() / 10**6
    upload_speed = st.upload() / 10**6

    return download_speed, upload_speed

download_speed, upload_speed = get_internet_bandwidth()
print(f"Download Speed: {download_speed} Mbps")
print(f"Upload Speed: {upload_speed} Mbps")

hostname = socket.gethostname()
print(f"Hostname: {hostname}")

external_ip = urllib.request.urlopen('https://ident.me').read().decode('utf8')
ip_address = socket.gethostbyname(hostname)
print(f"IP Address: {ip_address}")
print(f"Public IP Address: {external_ip}")

mac_address = getmac.get_mac_address()
print(f"MAC Address: {mac_address}")