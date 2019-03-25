echo "Compressing data to be sent to the server side node."
rm -rf repo.zip
zip -rq repo.zip repo 

echo "Transfering data to the repo side node."
sshpass -f password ssh cd0201@l040101-ws07.ua.pt 'mkdir -p teste/RestaurantSocketCS'
sshpass -f password ssh cd0201@l040101-ws07.ua.pt 'rm -rf teste/RestaurantSocketCS/*'
sshpass -f password scp repo.zip cd0201@l040101-ws07.ua.pt:teste/RestaurantSocketCS

echo "Decompressing data sent to the repo side node."
sshpass -f password ssh cd0201@l040101-ws07.ua.pt 'cd teste/RestaurantSocketCS ; unzip -uq repo.zip'

echo "Compiling program files at the repo side node."
sshpass -f password ssh cd0201@l040101-ws07.ua.pt 'cd teste/RestaurantSocketCS ; find . -name "*.java" -print | xargs javac'

echo "End of compiling at the server side node."

echo "Executing program at the repo side node."
sshpass -f password ssh cd0201@l040101-ws07.ua.pt 'cd teste/RestaurantSocketCS/repo ; java RepoMain'

echo "Server  shutdown."
sshpass -f password ssh cd0201@l040101-ws07.ua.pt 'cd teste/RestaurantSocketCS/repo ; less log.txt'
