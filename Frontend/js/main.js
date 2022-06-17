const section_tareas = document.querySelector('.cont_tareas');
const form = document.querySelector('#form')
const btn = document.querySelector('#btnCrear')
let url = 'http://localhost:8080'
let subTareaEdit = {}

section_tareas.addEventListener("click", (e) => {

  if (e.target.classList[0] == "EliminarTarea") {
    eliminarTarea(e.target.previousElementSibling.textContent)
  }

  if (e.target.classList[0] == "completado") {
    console.log(e.target.parentElement.parentElement.parentElement.children[3].children[0])
    let check = e.target.parentElement.parentElement.parentElement.children[3].children[0]
    let checkN = (e.target.parentElement.parentElement.parentElement.children[0])
    let checkI = (e.target.parentElement.parentElement.parentElement.children[1])
    let nombre = (e.target.parentElement.parentElement.parentElement.children[1].textContent)
    let idH = (e.target.parentElement.parentElement.parentElement.children[0].textContent)
    let idP = (e.target.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.children[0].textContent)

    if(e.target.checked) {     
      check.disabled = true;
      modificarSubTarea(idP,idH,nombre,true)      
    }else{
      check.disabled = false;
      modificarSubTarea(idP,idH,nombre,false)
    }
  }

  if (e.target.classList[0] == "agregarSub") {     
    if (e.target.parentElement.children[4].textContent == "Agregar") {
      let info = {
        nombre:e.target.previousElementSibling.value,
        id:e.target.parentElement.children[1].children[1].textContent
      }
      crearSubTarea(info.nombre,info.id)      
    }
    if(e.target.parentElement.children[4].textContent == "Actualizar") {
      let form = e.target.previousElementSibling.value     
      modificarSubTarea(subTareaEdit.idPadre,subTareaEdit.idHijo,form,false) 

    }      
  }

  if (e.target.classList[0] == "EliminarSubTarea") {
    eliminarSubTarea(e.target.parentElement.parentElement.children[0].textContent)
  }

  if (e.target.classList[0] == "EditarSubTarea") {    
    subTareaEdit.nombre = e.target.parentElement.parentElement.parentElement.parentElement.children[1].children[0].children[1].textContent
    subTareaEdit.idPadre = e.target.parentElement.parentElement.parentElement.parentElement.parentElement.children[0].textContent,
    subTareaEdit.idHijo = e.target.parentElement.parentElement.children[0].textContent   
    
    let form = e.target.parentElement.parentElement.parentElement.parentElement.parentElement.children[1].children[3]
    let nombreB = e.target.parentElement.parentElement.parentElement.parentElement.parentElement.children[1].children[4]
    
    nombreB.textContent = "Actualizar"
    form.value = subTareaEdit.nombre

  }

})

btn.addEventListener("click", (e) => { 
  e.preventDefault();  
    crearTarea(document.querySelector('#tarea').value)
})



const plasmarTareas = (tareas) => {
    let resultados = ''
    let subta = ''
    tareas.forEach(tarea => {
      console.log(tarea)
      subta=''
      tarea.subtareas.forEach(subtarea => {        
        subta += `
        <tr class="table-light">
                    <th scope="row">${subtarea.id}</th>
                    <td class = "${subtarea.completado? "text-muted": ""}" >${subtarea.nombre}</td>
                    <td><div class="form-check form-switch">                    
                        <input ${subtarea.completado? "checked": "unchecked"} class="completado form-check-input" type="checkbox" id="flexSwitchCheckDefault">                        
                      </div></td>
                    <td><button type="submit" id="btnEditarSub" class="${subtarea.completado? "EditarSubTarea btn btn-info disabled": "EditarSubTarea btn btn-info"}">Editar</button></td>
                    <td><button type="submit" id="btnEliminarSub" class="EliminarSubTarea btn btn-danger">Eliminar</button></td>                                 
                  </tr>        
        `        
      })
        resultados += `
        <div class="containerTarea card border-primary mb-3">
        <spam class = "spamId">${tarea.id}</spam>
                <div class="cabezaTarea">
                <br>
                  <div class="d-flex justify-content-center" >            
                    <h2>${tarea.nombre}</h2>
                    <spam class = "spamId">${tarea.id}</spam>
                    <button type="submit" id="btnEliminar${tarea.id}" class="EliminarTarea btn btn-danger">Eliminar</button>                  
                  </div>                  
                  <br>                    
                    <input type="text" class="form-control" id="subtarea" aria-describedby="crear subtarea" placeholder="Subtarea">                   
                    <button type="submit" id="btnCrearSubtarea${tarea.id}" class="agregarSub btn btn-primary">Agregar</button>                    
                    </div>                        
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Nombre SubTarea</th>
                    <th scope="col">Completado?</th>                                  
                  </tr>
                </thead>
                <tbody>
                ${subta}
                </tbody>                              
              </table>              
            </div>
                    `    
    })    
    section_tareas.innerHTML = resultados
    
}


///CRUD TAREAS

async function mostrarTarea(){

    let res = await fetch(`${url}/api/tareas`)

    let data = await res.json()
    console.log(data)
    plasmarTareas(data)     
}

mostrarTarea()

async function crearTarea(nombre){
    
    let options = {
      method: "POST",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },
      body: JSON.stringify({
        nombre: nombre
        
      })
    },
      res = await fetch(`${url}/api/tarea`, options)
      mostrarTarea()             
}

async function eliminarTarea(id){
    
    let options = {
      method: "DELETE",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },     
    },
      res = await fetch(`${url}/api/tarea/${id}`, options)
      mostrarTarea()
}

///CRUD SUBTAREAS

async function crearSubTarea(nombre,id){
    
    let options = {
      method: "POST",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },
      body: JSON.stringify({        
            tarea: {
                id: id
            },
            nombre: nombre               
                 
      })
    },
      res = await fetch(`${url}/api/subtarea`, options)
      mostrarTarea()
}

async function modificarSubTarea(idP,idH,nombre,completado){
    
    let options = {
      method: "PUT",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },
      body: JSON.stringify({        
            tarea: {
                id: idP
            },
            nombre: nombre,
            completado: completado                
                 
      })
    },
      res = await fetch(`${url}/api/subtarea/${idH}`, options)
      mostrarTarea()
}

async function eliminarSubTarea(id){
    
    let options = {
      method: "DELETE",
      headers: {
        "Content-type": "application/json; charset=utf-8"
      },     
    },
      res = await fetch(`${url}/api/subtarea/${id}`, options)
      mostrarTarea()
}
