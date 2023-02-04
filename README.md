Very stupid alternative authentication server for some DRMs. Requires to forward domain to localhost in /etc/hosts.  
For game authentication run  
`iptables -t nat -A OUTPUT -o lo -p tcp --dport 80 -j REDIRECT --to-port 8080`