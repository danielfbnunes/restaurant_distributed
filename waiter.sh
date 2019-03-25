echo "Compressing data to be sent to the client side node."
rm -rf waiter.zip
zip -rq waiter.zip waiter

echo "Transfering data to the waiter side node."
sshpass -f password ssh cd0201@l040101-ws02.ua.pt 'mkdir -p teste/RestaurantSocketCS'
sshpass -f password ssh cd0201@l040101-ws02.ua.pt 'rm -rf teste/RestaurantSocketCS/*'
sshpass -f password scp waiter.zip cd0201@l040101-ws02.ua.pt:teste/RestaurantSocketCS




echo "Decompressing data sent to the waiter side node."
sshpass -f password ssh cd0201@l040101-ws02.ua.pt 'cd teste/RestaurantSocketCS ; unzip -uq waiter.zip'
echo "Compiling program files at the waiter side node."
sshpass -f password ssh cd0201@l040101-ws02.ua.pt 'cd teste/RestaurantSocketCS ; find . -name "*.java" -print | xargs javac'



echo "Executing program at the waiter side node."
sshpass -f password ssh cd0201@l040101-ws02.ua.pt 'cd teste/RestaurantSocketCS/waiter ; java WaiterMain'

echo "Terminated"
