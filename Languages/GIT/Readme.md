https://git-scm.com/docs

## Git init in a foloder
    go to that folder (cd /scratch/vtkrishn/my_repository)
    git init

## Do some changes like add a file and then commit it
    git add .
    git add .txt
    git add LICENSE Readme.md text.java
    git mv
    git rm

## Get the status
    git status

## Do the commit
    git commit -m 'changes to the file'

## Cloning an existing repository
    git clone https://github.com/vtkrishn/Learning.git

## Create a new branch
    git branch testing (create)
    git branch (list)
    git branch -d testing  (delete)


## To see the HEAD pointer of the the branch
    git log --oneline --decorate  
    git log --oneline --decorate --graph --all

## Checkout the branch
    git checkout testing (the branch will be switched and the HEAD pointer will be moved from the master to the testing branch)
    git checkout master (switch back to master)

## Add local repository to the server
    git remote add local_proj /srv/git/project.git    

## Get the details
    git log
    git show f2a44dd6dc413a816bad312d185f7a1fa8ee7a83
    git reflog

## Congfgiuration
    git config --global user.name "John Doe"
    git config --global user.email johndoe@example.com  
