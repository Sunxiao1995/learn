mkdir ~/prepare/practice/new
touch ~/prepare/practice/new/new.txt
echo "welcome to banyuan">~/prepare/practice/new/new.txt
mkdir -p ~/prepare/practice/newother/sub
cp ~/prepare/practice/new/new.txt ~/prepare/practice/newother/sub
mv ~/prepare/practice/new/new.txt ~/prepare/practice/new/new1.txt
mv ~/prepare/practice/newother/sub ~/prepare/practice
mv ~/prepare/practice/sub ~/prepare/practice/new2
rm -rf ~/prepare/practice/new*
