package com.horstmann.corejava;

/*
代理模式中对于接口的应用
*/

public class NetWorkTest {
    public static void main(String[] args) {
        Server server = new Server();

//        server.browse();

        ProxyServer proxyServer = new ProxyServer(server);

        proxyServer.browse();
    }
}

interface NetWork {
    void browse();
}

class Server implements NetWork {
    /**
     * 被代理类
     */
    @Override
    public void browse() {
        System.out.println("服务器开始联网");
    }
}

class ProxyServer implements NetWork {
    /**
     * 代理类
     */

    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    private void check() {
        System.out.println("联网之前的检查工作。");
    }

    @Override
    public void browse() {
        check();

        work.browse();
    }
}