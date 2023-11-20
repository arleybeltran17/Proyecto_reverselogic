//? -------------------------|| Modal Actualizacion Prenda ||-------------------------
document.addEventListener("DOMContentLoaded", function() {
    let updateButtons = document.querySelectorAll(".btncal");

    updateButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            let modal = document.getElementById("myModal1");
            let form = modal.querySelector("form");
    
            // Obtener los valores ingresados por el usuario en la tarjeta
            let PrendId = button.getAttribute("data-prend-id");
            let card = button.parentElement; // Almacenar la tarjeta para facilitar el acceso a los elementos
    
            let PrendMarca = card.querySelector(".cardPrend_Marca").textContent;
            let PrendTalla = card.querySelector(".cardPrend_Talla").textContent;
            let PrendDescrip = card.querySelector(".cardPrend_Descrip").textContent;
            let MateId = card.querySelector(".cardMate_Id").textContent;
            let ColorId = card.querySelector(".cardColor_Id").textContent;
            let ProdId = card.querySelector(".cardProd_Id").textContent;
    
            // Llenar los campos en la ventana modal con los valores obtenidos
            form.elements.Prend_Id.value = PrendId;
            form.elements.Prend_Marca.value = PrendMarca;
            form.elements.Prend_Talla.value = PrendTalla;
            form.elements.Prend_Descrip.value = PrendDescrip;
            form.elements.Mate_Id.value = MateId;
            form.elements.Color_Id.value = ColorId;
            form.elements.Prod_Id.value = ProdId;
    
            // Mostrar la ventana modal
            modal.style.display = "block";
        });
    });
    
    // Aquí, getUserById() es una función ficticia, debes implementarla para obtener los datos del usuario por su ID
    function getPrendById(PrendId, callback) {
        // Aquí, realiza una solicitud AJAX al servidor o cualquier otra lógica para obtener los datos del usuario
        // Supongamos que userData es un objeto que contiene la información del usuario por su ID
        let PrendData = {
            Prend_Id: PrendId,
            Prend_Marca: PrendMarca,
            Prend_Talla: PrendTalla,
            Prend_Descrip: PrendDescrip,
            Mate_Id: MateId,
            Color_Id: ColorId,
            Prod_Id: ProdId
        };
    
        // Llamar al callback con los datos del usuario
        callback(PrendData);
    }
    
    // Evento de cierre de la ventana modal
    let modal = document.getElementById("myModal1");
    let closeBtn = document.querySelector(".close1");
    
    closeBtn.addEventListener("click", function() {
        modal.style.display = "none";
    });
    
    window.addEventListener("click", function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });
});
