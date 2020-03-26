using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.Threading.Tasks;
using Newtonsoft.Json;

namespace CSharp_Socket
{
    class Program
    {

        private IPEndPoint serverAddress = new IPEndPoint(IPAddress.Parse("127.0.0.1"), 1337);
        Socket clientSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);

        static void Main(string[] args)
        {

            Program p = new Program();
            Console.WriteLine("Connected. Waiting for message");
           
            new Thread(() =>
            {
                p.ListenToServer();
            }).Start();
            

            int i = 0;
            while (true)
            {
                Thread.Sleep(3000);

                Student student = new Student(){Name = "Client C# Student", Id=i++};
                string json = JsonConvert.SerializeObject(student);
                p.SendToServer(json);
                Console.WriteLine("message sent...");
            }
           



            
            
        }


        private void ListenToServer()
        {
            clientSocket.Connect(serverAddress);

            List<Student> studentsReceived = new List<Student>();
            while (true)
            {
                // Receiving
                byte[] rcvLenBytes = new byte[4];
                clientSocket.Receive(rcvLenBytes);
                int rcvLen = System.BitConverter.ToInt32(rcvLenBytes, 0);
                byte[] rcvBytes = new byte[rcvLen];
                clientSocket.Receive(rcvBytes);
                String rcv = System.Text.Encoding.ASCII.GetString(rcvBytes);

                Console.WriteLine("Client received: " + rcv);

                Student student = JsonConvert.DeserializeObject<Student>(rcv);
                studentsReceived.Add(student);
                Console.WriteLine("Total students received: " + studentsReceived.Count);
            }
        }

        private void SendToServer(String jsonString)
        {
            // Sending
            int toSendLen = System.Text.Encoding.ASCII.GetByteCount(jsonString);
            byte[] toSendBytes = System.Text.Encoding.ASCII.GetBytes(jsonString);
            byte[] toSendLenBytes = System.BitConverter.GetBytes(toSendLen);
            clientSocket.Send(toSendLenBytes);
            clientSocket.Send(toSendBytes);
        }
    }




}
