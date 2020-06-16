var staticMapsInternal = []
function CreateStaticMap(mapHTML, image) {

    var map = {html:mapHTML, markers: []}

    var imgMap = mapHTML.getElementsByTagName('img')[0]

    imgMap.src = image

    f=function (position, click){
    
        var marker = document.createElement('div');
        marker.classList.add('marker')
        marker.style.left = position.x + "%"
        marker.style.top = position.y + "%"
        
        marker.addEventListener('click',click)

        this.html.appendChild(marker);

        this.markers.push(marker)
    }
    map.AddMarker=f.bind(map)

    z=function(){
    
        this.markers.forEach(function(elem){          
                var tmp = elem.style.left
                elem.style.left = elem.style.top
                elem.style.top = tmp
        })
    }
    map.onorientationchange=z.bind(map)
    
    staticMapsInternal.push(map)

    return map
}

function RelativePosition(x,y){

    return {x:x, y:y}
}

window.addEventListener("onorientationchange",function(){

    staticMapsInternal.forEach(function(map){
        map.onorientationchange()
    })
})
