var interval;

function produto() {
    document.querySelector('.conteudo').innerHTML = '';

    var select = document.getElementById("promocoes");
    var value = select.options[select.selectedIndex].value;

    if (value == "1") {
        if (interval) clearInterval(interval);
        var geladeira = "json/geladeira.json";
        fetch(geladeira)
            .then(function (response) {
                return response.json();
            })
            .then(function (obj) {
                var i = 0;
                var currentElement = null;
                var currentImage = null;
                interval = setInterval(function () {
                    if (i < obj.geladeiras.length) {
                        var element = document.createElement("div");
                        element.innerHTML =
                            "<br><strong> " + obj.geladeiras[i].marca + "</strong><br>" +
                            "<br>" + obj.geladeiras[i].modelo + "<br>" +
                            "<br> " + obj.geladeiras[i].valor + ",00<br><br>";

                        var image = document.createElement("img");
                        image.src = "img/geladeiras/geladeira0" + (i + 1) + ".jpg";
                        image.width = 200;
                        image.height = 200;

                        var conteudo = document.querySelector(".conteudo");
                        if (currentElement) {
                            conteudo.insertBefore(element, currentElement);
                            currentElement.remove();

                            conteudo.insertBefore(image, currentImage);
                            currentImage.remove();
                        } else {
                            conteudo.appendChild(element);
                            conteudo.appendChild(image);
                        }
                        currentElement = element;
                        currentImage = image;
                        i++;
                    } else {
                        i = 0;
                    }
                }, 1000);
            });
    } else if (value == "2") {
        if (interval) clearInterval(interval);
        var smartphone = "json/smarthphone.json";
        fetch(smartphone)
            .then(function (response) {
                return response.json();
            })
            .then(function (obj) {
                var i = 0;
                var currentElement = null;
                var currentImage = null;
                interval = setInterval(function () {
                    if (i < obj.smartphones.length) {
                        var element = document.createElement("div");
                        element.innerHTML =
                            "<strong><br>" + obj.smartphones[i].marca + "</strong><br>" +
                            "<br>" + obj.smartphones[i].modelo + "<br>" +
                            "<br>" + obj.smartphones[i].valor + ",00<br><br>";

                        var image = document.createElement("img");
                        image.src = "img/celulares/celular0" + (i + 1) + ".jpg";
                        image.width = 200;
                        image.height = 200;

                        var conteudo = document.querySelector(".conteudo");
                        if (currentElement) {
                            conteudo.insertBefore(element, currentElement);
                            currentElement.remove();

                            conteudo.insertBefore(image, currentImage);
                            currentImage.remove();
                        } else {
                            conteudo.appendChild(element);
                            conteudo.appendChild(image);
                        }
                        currentElement = element;
                        currentImage = image;
                        i++;
                    } else {
                        i = 0;
                    }
                }, 1000);
            });

    }
}
