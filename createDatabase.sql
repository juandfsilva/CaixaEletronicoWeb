create database sis_bancario;
use sis_bancario;

CREATE TABLE cliente(
cli_id integer(7) UNIQUE, auto_increment
cli_nome varchar(45) NOT NULL,
cli_tipo integer(3)
);

CREATE TABLE conta(
cli_id integer(7) NOT NULL,
con_conta integer(7) UNIQUE NOT NULL,
con_agencia integer(6) NOT NULL,
con_senha integer(4)NOT NULL,
con_codAcesso integer(3),
con_banco varchar(15) NOT NULL,
con_saldo double(15,2) null default '0.00',
con_bloqueio integer(1) default '0'
);

CREATE TABLE movimentacao(
mov_cod integer(11) UNIQUE auto_increment,
mov_data date NOT NULL,
mov_conta integer(6) NOT NULL,
mov_agencia integer(6) NOT NULL,
mov_tipo integer(1),
mov_valor decimal(15,2) default '0.00',
mov_accTo integer(7),
mov_agTo integer(6),
mov_docto integer(25),
mov_doctoCli integer(25),
mov_diaVenct integer(2)
);

CREATE TABLE log(
log_cod integer(7) UNIQUE AUTO_INCREMENT,
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


