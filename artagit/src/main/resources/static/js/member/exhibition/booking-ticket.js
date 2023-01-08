window.addEventListener("load", function(e){
	const cNumBox = document.querySelector(".client-number");
	const cInfoBox = document.querySelector(".client-info");
	const plus = document.querySelector(".plus");
	const minus = this.document.querySelector(".minus");
	const numBox = this.document.querySelector(".count");
	const priceBox = this.document.querySelector(".price");
	const totalPrice = this.document.querySelector(".total-price");
	// let count = numBox.innerText;
	let i = 0;
	let price = priceBox.innerText.replace(/[^0-9]/g, "");

	plus.onclick = function(e){
		e.preventDefault();
		cInfoBox.classList.remove("d-none");

		i++;

		console.log("수량: " + i);
		console.log("금액: " + price*i);

		numBox.innerText = i;
		totalPrice.innerText = (i*price).toLocaleString();
	}

	minus.onclick = function(e){
		e.preventDefault();
		if(i>0){
			i--;
	
			console.log("수량: "+i);
			console.log("금액: "+price);
	
			numBox.innerText = i;
			totalPrice.innerText = (i*price).toLocaleString();
		} else {
			numBox.innerText = 0;
		}
	}
	
});