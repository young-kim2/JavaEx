package com.javaex.network.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		//서버 소켓
		ServerSocket serverSocket=null;
		
		try {
			//바인드-IP연결
			serverSocket=new ServerSocket();
			
			InetSocketAddress ips=new InetSocketAddress("192.168.0.12",139);
			serverSocket.bind(ips);
			
			//시작 메시지
			System.out.println("<서버 시작>");
			System.out.println("SERVER:[연결을 기다립니다.]");
			
			//연결 대기
			Socket socket=serverSocket.accept();
			
			//클라이언트 정보 확인
			InetSocketAddress socketAddress=(InetSocketAddress)socket.getRemoteSocketAddress();
			//원격지 소켓의 주소 확인
			System.out.println("SERVER:[클라이언트가 연결되었습니다]");
			System.out.println("클라이언트:"+socketAddress.getAddress()+":"+socketAddress.getAddress()+":"+socketAddress.getPort());
			
			//메시지 수신
			InputStream is=socket.getInputStream();
			Reader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			//메시지 읽어오기
			String message;
			while(true) {
				message=br.readLine();
				if(message==null) {
					//읽을 메시지 없음
					System.out.println("SERVER:접속을 종료합니다.");
					break;
				}
				System.out.println("SERVER: [수신 메시지]"+message);
			}
			//후처리
			System.out.println("SERVER:[서버를 종료합니다]");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					serverSocket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
	}
}
