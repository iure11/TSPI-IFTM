function getTextServer() {

  removerDivs()

  const container = document.querySelector('.container');
  const grid = container.querySelector('.grid');

  var filename = "https://api.themoviedb.org/3/movie/popular?api_key=c15dad394636b8b7024409057d9a956a&language=pt-BR&page=1"
  fetch(filename)
    .then(response => response.json())
    .then(data => {
      const startIndex = 0; // índice inicial para exibição
      const numItems = 10; // número de itens a serem exibidos

      const slicedResults = data.results.slice(startIndex, startIndex + numItems); // seleciona os próximos 10 elementos



      for (let i = 0; i < slicedResults.length; i++) {
        const result = slicedResults[i];

        // Cria a div box
        const box = document.createElement('div');
        box.classList.add('box');

        const titulo = document.createElement('div');
        titulo.classList.add('titulo');
        titulo.innerHTML = '<b>Título:</b> ' + result.original_title;

        const mostrarTexto = () => {
          // Verifica se o elemento "before" já foi adicionado ao "titulo"
          if (!titulo.querySelector('.before')) {
            const before = document.createElement('div');
            before.classList.add('before');
            before.textContent = result.overview;
            titulo.appendChild(before);
          }
          // Verifica se o evento "mouseover" já foi removido para o "titulo"
          if (!titulo.classList.contains('mostrado')) {
            titulo.classList.add('mostrado');
            titulo.removeEventListener('mouseover', mostrarTexto);
          }
          // Adiciona novamente o evento "mouseover" após a exibição da descrição
          titulo.addEventListener('mouseover', mostrarTexto);
        };

        // Adiciona evento "mouseout" para a div "box"
        box.addEventListener('mouseout', function () {
          const before = titulo.querySelector('.before');
          if (before) {
            titulo.removeChild(before);
            titulo.classList.remove('mostrado');
          }
        });

        titulo.addEventListener('mouseover', mostrarTexto);

        box.appendChild(titulo);

        document.querySelector('.grid').appendChild(box);

        // Cria o elemento de imagem

        const img = document.createElement('img');
        img.src = 'https://image.tmdb.org/t/p/w500/' + result.poster_path;
        box.appendChild(img);

        // Cria um elemento para a data de lançamento e adiciona ao box
        const releaseDate = document.createElement('p');
        releaseDate.innerHTML = '<b>Data de Lançamento:</b> ' + result.release_date;
        box.appendChild(releaseDate);

        // Cria um elemento para a nota do filme e adiciona ao box
        const voteAverage = document.createElement('p');
        voteAverage.innerHTML = '<b>Nota de 0 a 10:</b> ' + result.vote_average;
        box.appendChild(voteAverage);

        // Cria um elemento para o idioma original e adiciona ao box
        const originalLanguage = document.createElement('p');
        originalLanguage.innerHTML = '<b>Idioma: </b> ' + result.original_language;
        box.appendChild(originalLanguage);

        // Adiciona a div box à div grid
        grid.appendChild(box);
        ativarHover();
      }
    })
    .catch(error => console.error(error));


}

function ativarHover() {
  const divs = document.querySelectorAll(".box");
  divs.forEach((div) => {
    div.classList.add("ativado");
  });
}


function removerDivs() {
  const container = document.querySelector(".container");
  const grid = container.querySelector(".grid");
  const divs = grid.querySelectorAll(".box");

  for (let i = 0; i < divs.length; i++) {
    grid.removeChild(divs[i]);
  }

}

function GeraFilesIure() {

  removerDivs();

  const container = document.querySelector('.container');
  const grid = container.querySelector('.grid');

  var filename = "https://api.themoviedb.org/3/list/8245512?api_key=c15dad394636b8b7024409057d9a956a&language=pt-BR"
  fetch(filename)
    .then(response => response.json())
    .then(data => {
      const startIndex = 0; // índice inicial para exibição
      const numItems = 10; // número de itens a serem exibidos

      const slicedResults = data.items.slice(startIndex, startIndex + numItems); // seleciona os próximos 10 elementos



      for (let i = 0; i < slicedResults.length; i++) {
        const result = slicedResults[i];

        // Cria a div box
        const box = document.createElement('div');
        box.classList.add('box');

        const titulo = document.createElement('div');
        titulo.classList.add('titulo');
        titulo.innerHTML = '<b>Título:</b> ' + result.original_title;

        const mostrarTexto = () => {
          // Verifica se o elemento "before" já foi adicionado ao "titulo"
          if (!titulo.querySelector('.before')) {
            const before = document.createElement('div');
            before.classList.add('before');
            before.textContent = result.overview;
            titulo.appendChild(before);
          }
          // Verifica se o evento "mouseover" já foi removido para o "titulo"
          if (!titulo.classList.contains('mostrado')) {
            titulo.classList.add('mostrado');
            titulo.removeEventListener('mouseover', mostrarTexto);
          }
          // Adiciona novamente o evento "mouseover" após a exibição da descrição
          titulo.addEventListener('mouseover', mostrarTexto);
        };

        // Adiciona evento "mouseout" para a div "box"
        box.addEventListener('mouseout', function () {
          const before = titulo.querySelector('.before');
          if (before) {
            titulo.removeChild(before);
            titulo.classList.remove('mostrado');
          }
        });

        titulo.addEventListener('mouseover', mostrarTexto);

        box.appendChild(titulo);

        document.querySelector('.grid').appendChild(box);




        // Cria o elemento de imagem

        const img = document.createElement('img');
        img.src = 'https://image.tmdb.org/t/p/w500/' + result.poster_path;
        box.appendChild(img);

        // Cria um elemento para a data de lançamento e adiciona ao box
        const releaseDate = document.createElement('p');
        releaseDate.innerHTML = '<b>Data de Lançamento:</b> ' + result.release_date;
        box.appendChild(releaseDate);

        // Cria um elemento para a nota do filme e adiciona ao box
        const voteAverage = document.createElement('p');
        voteAverage.innerHTML = '<b>Nota de 0 a 10:</b> ' + result.vote_average;
        box.appendChild(voteAverage);

        // Cria um elemento para o idioma original e adiciona ao box
        const originalLanguage = document.createElement('p');
        originalLanguage.innerHTML = '<b>Idioma: </b> ' + result.original_language;
        box.appendChild(originalLanguage);

        // Adiciona a div box à div grid
        grid.appendChild(box);
        ativarHover();
      }
    })
    .catch(error => console.error(error));
}