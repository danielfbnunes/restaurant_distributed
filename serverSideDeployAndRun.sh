xterm -T "Repo" -hold -e "./repo.sh" &
sleep 5
xterm -T "Kitchen" -hold -e "./kitchen.sh" &
sleep 5
xterm -T "Bar" -hold -e "./bar.sh" &
sleep 5
xterm -T "Table" -hold -e "./table.sh" &
