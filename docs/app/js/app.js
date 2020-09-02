
var urlstring = window.location.href; // "http://www.example.com/t.html?c=Devesh"; 
var url = new URL(urlstring);
var id = url.searchParams.get("download");
console.log("Current id: " + id);
if(id=="plugin"){
    window.location.href = "https://play.google.com/store/apps/details?id=devesh.b.pharm.guide.mu.ebook";

}



