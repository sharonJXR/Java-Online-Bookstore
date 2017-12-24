var book_store={
    setIFrame:function(src){
       var dest = src.split("#conent")[1];
       if(dest)document.getElementById('iframe_content').src = "pages"+dest;
    }
}
