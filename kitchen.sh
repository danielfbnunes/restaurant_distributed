echo "Compressing data to be sent to the server side node."
rm -rf kitchen.zip
zip -rq kitchen.zip kitchen

echo "Transfering data to the kitchen side node."
sshpass -f password ssh cd0201@l040101-ws04.ua.pt 'mkdir -p teste/RestaurantSocketCS'
sshpass -f password ssh cd0201@l040101-ws04.ua.pt 'rm -rf teste/RestaurantSocketCS/*'
sshpass -f password scp kitchen.zip cd0201@l040101-ws04.ua.pt:teste/RestaurantSocketCS

echo "Decompressing data sent to the kitchen side node."
sshpass -f password ssh cd0201@l040101-ws04.ua.pt 'cd teste/RestaurantSocketCS ; unzip -uq kitchen.zip'

echo "Compiling program files at the kitchen side node."
sshpass -f password ssh cd0201@l040101-ws04.ua.pt 'cd teste/RestaurantSocketCS ; find . -name "*.java" -print | xargs javac'

echo "Executing program at the kitchen side node."
sshpass -f password ssh cd0201@l040101-ws04.ua.pt 'cd teste/RestaurantSocketCS/kitchen ; java KitchenMain l040101-ws07.ua.pt 22602 l040101-ws08.ua.pt 22602'

echo "Server  shutdown."
