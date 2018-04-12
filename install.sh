~/.config/gtk-3.0/gtk.css
    2  cd ~/.config/gtk-3.0/gtk.css
    3  cd ~/.config/gtk-3.0/
    4  ls
    5  vi gtk.css
wget https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
   15  sudo yum install ./google-chrome-stable_current_*.rpm
   16  gsettings set org.gnome.nautilus.icon-view default-zoom-level small

https://github.com/vtkrishn/Learning.git
sudo yum install git

git --version
git clone https://github.com/vtkrishn/Learning.git
git config credential.helper store

git status
   55  git checkout -- test.txt
   56  git status
   57  git rm test.txt

 45  git config --global user.email "vin.sinin@gmail.com"
 46  git config --global user.name "Vinod Krishnan"

tar xzf pycharm-community-2018.1.1.tar.gz
ln -s /usr/local/bin/charm Desktop/pycharm


elasticsearch
-------------------
  107  rpm --import https://artifacts.elastic.co/GPG-KEY-elasticsearch
  108  vi /etc/yum.repos.d/elasticsearch.repo
  109  sudo yum install elasticsearch
  110  sudo chkconfig --add elasticsearch
  111  sudo -i service elasticsearch start
  112  sudo -i service elasticsearch stop
  113  sudo /bin/systemctl daemon-reload
  114  sudo /bin/systemctl enable elasticsearch.service
  115  sudo systemctl start elasticsearch.service
  116  sudo systemctl stop elasticsearch.service
sudo -i service elasticsearch start
vi /etc/elasticsearch/elasticsearch.yml

kibana
----------
  125  rpm --import https://artifacts.elastic.co/GPG-KEY-elasticsearch
  126  vi /etc/yum.repos.d/kibana.repo
  127  sudo yum install kibana
  128  sudo chkconfig --add kibana
  129  sudo -i service kibana start
  130  sudo -i service kibana stop
  131  sudo /bin/systemctl daemon-reload
  132  sudo /bin/systemctl enable kibana.service
  133  sudo systemctl start kibana.service
  134  sudo systemctl stop kibana.service
  135  sudo -i service kibana start
vi /etc/kibana/kibana.yml

mongo
------ 
138  vi /etc/yum.repos.d/mongodb-org-3.6.repo
  139  sudo yum install -y mongodb-org
  140  vi /etc/mongod.conf 
  141  sudo service mongod start
  142  sudo chkconfig mongod on
  143  sudo service mongod stop
  144  sudo service mongod restart
  145  mongo

nodejs
-------
  150  curl --silent --location https://rpm.nodesource.com/setup_9.x | sudo bash -
  151  sudo yum install -y nodejs








