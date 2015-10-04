create database sis_bancario;
use sis_bancario;

CREATE TABLE cliente(
cli_conta integer(7) UNIQUE,
cli_nome varchar(45) NOT NULL,
cli_tipo integer(3)
);

CREATE TABLE conta(
con_conta integer(7) UNIQUE NOT NULL,
con_agencia integer(6) NOT NULL,
con_senha integer(4)NOT NULL,
con_codAcesso integer(3),
con_saldo decimal(15,2) null default '0.00'
);

CREATE TABLE movimentacao(
mov_cod integer(11) UNIQUE auto_increment,
mov_data date NOT NULL,
mov_hora time NOT NULL,
mov_conDebito integer(6) NOT NULL,
mov_conDestino integer(7),
mov_codDebito integer(11),
mov_valor decimal(15,2) default '0.00'
);

CREATE TABLE log(
log_cod integer(7) UNIQUE auto_increment,
log_movCod integer(6) NOT NULL,
log_conDebito integer(7) NOT NULL,
log_agencia integer(6) NOT NULL,
log_valor decimal(15,2) NOT NULL
);

CREATE TABLE debAutom(
deb_cod integer(7) UNIQUE auto_increment,
deb_tipo integer(3) NOT NULL,
deb_operadora integer(7) NOT NULL,
deb_codConsumidor integer(6) NOT NULL,
deb_data date NOT NULL,
deb_hora time NOT NULL,
deb_valor decimal(15,2) NOT NULL
);

