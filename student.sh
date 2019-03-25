echo "Compressing data to be sent to the client side node."
rm -rf student.zip
zip -rq student.zip student 

echo "Transfering data to the student side node."
sshpass -f password ssh cd0201@l040101-ws01.ua.pt 'mkdir -p teste/RestaurantSocketCS'
sshpass -f password ssh cd0201@l040101-ws01.ua.pt 'rm -rf teste/RestaurantSocketCS/*'
sshpass -f password scp student.zip cd0201@l040101-ws01.ua.pt:teste/RestaurantSocketCS

echo "Decompressing data sent to the student side node."
sshpass -f password ssh cd0201@l040101-ws01.ua.pt 'cd teste/RestaurantSocketCS ; unzip -uq student.zip'

echo "Compiling program files at the student side node."
sshpass -f password ssh cd0201@l040101-ws01.ua.pt 'cd teste/RestaurantSocketCS ; find . -name "*.java" -print | xargs javac'

echo "Executing program at the student side node."
sshpass -f password ssh cd0201@l040101-ws01.ua.pt 'cd teste/RestaurantSocketCS/student ; java StudentMain'

echo "Terminated"
