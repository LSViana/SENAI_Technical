//Fun��o para procurar o maior elemento do vetor
//retorna: O �ndice de maior elemento
funcao maior() : inteiro

var
   maiorIndice, i : inteiro

inicio
   //Marca o primeiro �ndice como o maior
   maiorIndice <- 0

   //La�o de compara��o
   para i de 1 ate 9 passo 1 faca
      se (alturas[i] > alturas[maiorIndice]) entao
         maiorIndice <- i
      fimse
   fimpara

   //retorno da fun��o
   retorne maiorIndice
fimfuncao






Algoritmo "Maior"
// Disciplina   : [L�gica de Programa��o]
// Professor    : Felipe Pereira de Oliveira
Var
   alturas : vetor[0..9] de real
   i, maior: inteiro
Inicio

   //Recebendo os valores
   para i de 0 ate 9 passo 1 faca
      //Armazena valor aleat�rio
      alturas[i] <- randi(10)
   fimpara


   //Chama a fun��o e armazenando o retorno

   maior <- maior()



   //Exibindo informa��es
   escreval("O maior valor esta no �ndice: ", maior)
   escreval("Seu valor �: ", alturas[maior])
Fimalgoritmo