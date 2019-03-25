echo "Compressing data to be sent to the client side node."
rm -rf chef.zip
zip -rq chef.zip chef

echo "Transfering data to the chef side node."
sshpass -f password ssh cd0201@l040101-ws03.ua.pt 'mkdir -p teste/RestaurantSocketCS'
sshpass -f password ssh cd0201@l040101-ws03.ua.pt 'rm -rf teste/RestaurantSocketCS/*'
sshpass -f password scp chef.zip cd0201@l040101-ws03.ua.pt:teste/RestaurantSocketCS

echo "Decompressing data sent to the chef side node."
sshpass -f password ssh cd0201@l040101-ws03.ua.pt 'cd teste/RestaurantSocketCS ; unzip -uq chef.zip'
echo "Compiling program files at the chef side node."
sshpass -f password ssh cd0201@l040101-ws03.ua.pt 'cd teste/RestaurantSocketCS ; find . -name "*.java" -print | xargs javac'

echo "Executing program at the chef side node."
sshpass -f password ssh cd0201@l040101-ws03.ua.pt 'cd teste/RestaurantSocketCS/chef ; java ChefMain'

echo "Terminated"
