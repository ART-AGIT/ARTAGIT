
//window.addEventListener("load",function(){



function checkAll(checkAll)  {
    let checkboxes = document.querySelectorAll('input[type="checkbox"]');
    var checkAll = document.querySelector(".chkAll");
    
    checkboxes.forEach((checkbox) => {
        checkbox.checked = checkAll.checked;
    })
}

//});