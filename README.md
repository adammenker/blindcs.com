# Overview of the project
---
##### Tech Stack/Tools:
- Frontend: React
- Backend: Spring Boot
- DB: MySQL
- Hosting: AWS
- Docker

##### Description:
blindcs.com is designed to be an anonymous messaging board for students to make posts about anything computer science related (classes, internships, interviews, etc.).

# How to get started!
---
### Setting up your environment
##### Step 0: Download all the tools you will need
You will need to download VSCode and IntelliJ IDEA. For IntelliJ IDEA, it is important that you get the Ultimate Edition. Use the licensing provided by Mizzou (all students get the Ultimate Edition for free so follow IntelliJ's steps to do that). Downloading stuff often needs troubleshooting so I will try my best to help with that but since it is pretty specific to your computer, google searches will likely help more.

##### Step 1: Clone the project
To start contributing you will first need to clone (make a local copy) of the code. Since this is a local copy you can make all the changes you want without affecting anyone else's code/environemnt so feel free to experiment. To do this navigate to whatever folder in your terminal where you would like to store the project (e.g. Desktop) and then run this command:
```
git clone https://github.com/adammenker/blindcs.com.git
```

##### Step 2: Setup Frontend
This step is very easy. Simply navigate to the ```/blindcs-frontend``` directory and run this command in your terminal:
```
npm start
```
This will start a local server for the frontend and any changes that you make to the code in the frontend directory will then be viewable to you alone in your browser.

##### Step 3: Setup Backend (recommended)
If you are interested in contributing to the backend you will have to do this step but it is not necessary if you are only interested in the frontend. You can also decide at a later point to set up the backend and their will be no issues. This step must be done in IntelliJ IDEA.

You will need to install Java 8. By typing ```java -version``` you will be able to see if you have java installed and what version you are using. If your version is not ```1.8.0_xyz`` this means you are not running java 8. If that is the case you must change java versions. 

Furthermore, if it says you are running the 'Oracle' version you will need to switch to openjdk. Java was created by Oracle (kind of) and as time went on, there have been other entities that have spun off of Oracle's java and made their own copy. While these different copies of java are basically identical, there are some key differences. Firstly, Oracle requires you to purchase licensing for their version of java if you ever intend to make a commercial app with their version of java. That is where openjdk comes in. It is an extremely popular open source copy of java. I am using adoptopenjdk (a copy of openjdk) maintained by Java developers and vendors including Azul, Amazon, GoDaddy, IBM, jClarity (acquired by Microsoft), Microsoft, New Relic, Pivotal and Red Hat. For this reason you will need to get openjdk. Here is a link to where I installed my version of openjdk and I recommend it: https://adoptopenjdk.net/installation.html?variant=openjdk8&jvmVariant=hotspot 

##### Running the app
You have officially set up everything and now all you have to do to start the frontend is run ```npm start```. To start the backend, open IntelliJ and navigate to the ```BlindcsApplication``` file inside ```blindcs/src/main/java/com.interviewprep.blindcs``` package. From here, simply click the green run arrow on the left side on the same line as the class name. This will start your server. Test this by going to 'localhost:8080/helloworld' and you will see a hello world message. This should set you up to then use the green run arrow on the top right of your editor and the red stop square. Whenever you click the green run arrow the server will start and whenever you click the red stop square the server will stop. The frontend client conveniently changes as you make changes to your code, but if you change the backend you must restart your server for your changes to be reflected.

# How to contribute
---
### Writing code
##### Frontend
When you are writing code for the frontend, you will only need to make changes to the files in the `/src` directory. If you need to install a dependency that will change your package.json file but no need to write anything in it because it will do it automatically.
##### Backend
When you are writing code for the backend, you will write the actual code in the `src/main/java` directory but we will also be writing tests for our code in the `src/test` directory

### Using git/GitHub
It is paramount you understand how to use git if you are going to be a software engineer so I think you should watch some tutorials on youtube or read some documentation. The general flow of our app though will be to look at the task board and pick up a task from it. Once you have something you intend to work on, you will create a branch for that task (and that task alone, do not complete multiple tasks on the same branch). Once you have finished you task we will merge your branch back into its parent branch. This terminology will make sense once you learn about git. We will discuss how we are using git in more detail in the discord channel.

---
I am excited to work on this project with you all. If you have any questions feel free to message in the discord. You don't need any experience whatsoever to contribute. If you want to contribute though, it will require you to teach yourself some things on your own such as JavaScript, React, Java, or Spring Boot with tutorials. This might be your first exposure to a large codebase and you will see a lot of files that you have no idea what they do. This is normal and alot of these are pre-generated files so the only files that you should be concerned with are the ones in the directories I mentioned above. Also, once again, since this is something I was concerned about when working on a large project for the first time, it is impossible to break the code for anyone else, feel free to make all the changes you want since I will have to approve everything before it is merged into the code base.
# Look to the `documentation` directory for more info on the project