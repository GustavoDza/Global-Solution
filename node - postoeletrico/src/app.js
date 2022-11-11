const express = require('express');
const app = express();
const mysql = require('mysql');
const http = require('http');
const ejs = require('ejs');

//conectando com mysql
const connection = mysql.createConnection({
    host: "localhost",
    port: "3306",
    user: "root",
    password: "password",
    database: "postoeletrico"
});

app.use(express.json());
app.use(express.urlencoded({extended: true}));

app.use(function (req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept, x-access-token');
    res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');
    next();
});

//pagina inicial
app.get("/", function(req, res){
    res.sendFile(__dirname + "/pages/index.html");
})

//pagina cadastro de ambientes
app.get("/cadastro-ambiente", function(req, res){
    res.sendFile(__dirname + "/pages/cadastro-ambiente.html");
})

//cadastrar ambiente
app.post("/cadastrar-ambiente", function(req, res){
    const data = JSON.stringify({
        cidade: req.body.cidade,
        bairro: req.body.bairro,
        estado: req.body.estado,
        temperatura: req.body.temperatura,
        qualidadeDoAr: req.body.qualidadeDoAr
    });
    const options = {
        host: "localhost",
        port: 8080,
        proxy: "http://localhost:8080",
        path: "/ambientes",
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Content-Lenght": data.length,
        },
        auth: 'user:$2y$10$wZyDg.86gBs2rZcPP9/YgefufNe71uAFXvlrAttwoCHM8JQeUxRGe'
    };
    const request = http.request(options, (res)=>{
        console.log("statusCode: ", res.statusCode);
        let result = "";
        res.on("data",(chunk)=>{
            result += chunk;
        });
        res.on("end", ()=>{
            console.log("Result is: " + result);
        });
    });
    request.on("error", (err)=>{
        console.log("Error: " + err.message);
    });
    request.write(data);
    request.end()
    res.redirect("/");
})


//listar ambiente

app.get("/lista-ambiente", function(req, res){
    const data = JSON.stringify({
        cidade: req.body.cidade,
        bairro: req.body.bairro,
        estado: req.body.estado,
        temperatura: req.body.temperatura,
        qualidadeDoAr: req.body.qualidadeDoAr
    })
    const options = {
        host: "localhost",
        port: 8080,
        proxy: "http://localhost:8080",
        path: "/ambientes",
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        auth: 'user:$2y$10$wZyDg.86gBs2rZcPP9/YgefufNe71uAFXvlrAttwoCHM8JQeUxRGe'
    };
    const request = http.request(options, (res)=>{
        console.log("statusCode: ", res.statusCode);
        let result = "";
        res.on("data",(chunk)=>{
            result += chunk;
        });
        res.on("end", ()=>{
            console.log("Result is: " + result);
        });
    });
    request.on("error", (err)=>{
        console.log("Error: " + err.message);
    });
    request.end()
    res.json(data)
})


//pagina de cadastro de carro
app.get("/cadastro-carro", function(req, res){
    res.sendFile(__dirname + "/pages/cadastro-carro.html");
})

//cadastrar carro
app.post("/cadastrar-carro", function(req, res){
    const data = JSON.stringify({
        marca: req.body.marca,
        modelo: req.body.modelo,
        placa: req.body.placa,
        quilomtragem: req.body.quilomtragem,
        ambiente: req.body.ambiente
    });
    const options = {
        host: "localhost",
        port: 8080,
        proxy: "http://localhost:8080",
        path: "/carros",
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Content-Lenght": data.length,
        },
        auth: 'user:$2y$10$wZyDg.86gBs2rZcPP9/YgefufNe71uAFXvlrAttwoCHM8JQeUxRGe'
    };
    const request = http.request(options, (res)=>{
        console.log("statusCode: ", res.statusCode);
        let result = "";
        res.on("data",(chunk)=>{
            result += chunk;
        });
        res.on("end", ()=>{
            console.log("Result is: " + result);
        });
    });
    request.on("error", (err)=>{
        console.log("Error: " + err.message);
    });
    request.write(data);
    request.end()
    res.redirect("/");
})

//listar carro
app.get("/lista-carro", function(req, res){
    const data = JSON.stringify({
        marca: req.body.marca,
        modelo: req.body.modelo,
        placa: req.body.placa,
        quilomtragem: req.body.quilomtragem,
        ambiente: req.body.ambiente
    })
    const options = {
        host: "localhost",
        port: 8080,
        proxy: "http://localhost:8080",
        path: "/carros",
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        auth: 'user:$2y$10$wZyDg.86gBs2rZcPP9/YgefufNe71uAFXvlrAttwoCHM8JQeUxRGe'
    };
    const request = http.request(options, (res)=>{
        console.log("statusCode: ", res.statusCode);
        let result = "";
        res.on("data",(chunk)=>{
            result += chunk;
        });
        res.on("end", ()=>{
            console.log("Result is: " + result);
        });
    });
    request.on("error", (err)=>{
        console.log("Error: " + err.message);
    });
    request.end()
    res.json(data)
})

//servidor
app.listen(3000, function(){
    console.log("Server is running on 3000");
})