cd /home/travis/build/jukkacle/raspberrypi-command-execute 
git config --global user.email "shibu@shibu.com" 
git config --global user.name "Shibu Travis" 

git clone https://jukkacle:$GITHUB_API_KEY@github.com/jukkacle/raspberrypi-command-execute
cd raspberrypi-command-execute
cp "/home/travis/.m2/repository/com/vypeensoft/RaspberryPi_Command_Execute/1.0/RaspberryPi_Command_Execute-1.0.apk" releases
git add releases/*
git commit -m "Travis build $ TRAVIS_BUILD_NUMBER commited APK [skip ci] " 
git push origin master
echo -e" Done \ n "
