echo "Compressing data to be sent to the server side node."
rm -rf bar.zip
zip -rq bar.zip bar 

echo "Transfering data to the bar side node."
sshpass -f password ssh cd0201@l040101-ws08.ua.pt 'mkdir -p teste/RestaurantSocketCS'
sshpass -f password ssh cd0201@l040101-ws08.ua.pt 'rm -rf teste/RestaurantSocketCS/*'
sshpass -f password scp bar.zip cd0201@l040101-ws08.ua.pt:teste/RestaurantSocketCS

echo "Decompressing data sent to the bar side node."
sshpass -f password ssh cd0201@l040101-ws08.ua.pt 'cd teste/RestaurantSocketCS ; unzip -uq bar.zip'

echo "Compiling program files at the bar side node."
sshpass -f password ssh cd0201@l040101-ws08.ua.pt 'cd teste/RestaurantSocketCS ; find . -name "*.java" -print | xargs javac'

echo "Executing program at the bar side node."
sshpass -f password ssh cd0201@l040101-ws08.ua.pt 'cd teste/RestaurantSocketCS/bar ; java BarMain l040101-ws07.ua.pt 22602'

echo "Server  shutdown."
