console.log(variavel); // => da undefined pq a variavel existe mas nao antes dessa linha 
var variavel = 10;
console.log(variavel);

const constante = 'abc';
// constante = 123; => daria erro pq nao pode mudar uma variavel const
console.log(constante);

// console.log(mude); => daria erro ja que a variavel ainda nao foi criada
let mude = 'abc';
mude = 123;
console.log(mude);

if (true) { // escopo é o próprio IF
    let escopo = 'abc';
    escopo = 'escopo';
    console.log(escopo);
}
// console.log(escopo); => daria erro ja que o let so cria a variavel dentro do escopo dele