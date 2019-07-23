set team_id=%1
set server_ip=%2
set server_port=%3
cd jar
java -jar demo.jar %team_id% %server_ip% %server_port%

EXIT