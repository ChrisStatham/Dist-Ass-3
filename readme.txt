-----How to Run-----
You will need at least 3 shell windows to run this program

1. type "ant" into the command line to compile the code base.
2. Change each shell directory to the "bin" folder
3. run "rmiregistry" in the first shell window
4. run "java Server" in the second shell window
5. Each client is run by "java Client"

-----Problem Specification-----
The program is to facilitate point-to-point communication through a server. Clients should be able to send and receive messages,and they should also be able to private message indvidiuals. Currently the features that I have implemented are:

- Clients all join the room the same room currently
- Clients by default message everyone in the room
- Clients receive all messages sent to the room 
- Using /list the Client can see all of the users currently in the room
- Using /w <name> the Client can message a individual user for example /w Bob Hey bob!
  would send "WISPER chris: Hey bob!" to the user Bob

-----Algorithm-----
For this program I decided to use RMI to facilitate communication between the clients and the server.

Server{
  Server(){
    join RMI database;
  }

  joinRoom(String client, String room){
    get client from RMI database;
  }

  sendMessage(Message m){
    determine type of message;
    if (wisper){
     send message to client wisper.getTo();
    }else{
     send message to room m.getTo(); 
  }

