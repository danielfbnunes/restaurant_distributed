echo "Compressing data to be sent to the server side node."
rm -rf table.zip
zip -rq table.zip table 

echo "Transfering data to the table side node."
sshpass -f password ssh cd0201@l040101-ws05.ua.pt 'mkdir -p teste/RestaurantSocketCS'
sshpass -f password ssh cd0201@l040101-ws05.ua.pt 'rm -rf teste/RestaurantSocketCS/*'
sshpass -f password scp table.zip cd0201@l040101-ws05.ua.pt:teste/RestaurantSocketCS

echo "Decompressing data sent to the table side node."
sshpass -f password ssh cd0201@l040101-ws05.ua.pt 'cd teste/RestaurantSocketCS ; unzip -uq table.zip'

echo "Compiling program files at the table side node."
sshpass -f password ssh cd0201@l040101-ws05.ua.pt 'cd teste/RestaurantSocketCS ; find . -name "*.java" -print | xargs javac'

echo "Executing program at the table side node."
sshpass -f password ssh cd0201@l040101-ws05.ua.pt 'cd teste/RestaurantSocketCS/table ; java TableMain l040101-ws07.ua.pt 22602 l040101-ws08.ua.pt 22602'

echo "Server  shutdown."
