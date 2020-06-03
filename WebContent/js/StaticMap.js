let staticMapsInternal = []
function CreateStaticMap(mapHTML, image)
{
    const map = {html:mapHTML, markers: []}

    const imgMap = mapHTML.getElementsByTagName('img')[0]

    imgMap.src = image

    f = function (position, click)
    {
        var marker = document.createElement('div');
        marker.classList.add('marker')
        marker.style.top = position.y + "%"
        marker.style.left = position.x + "%"


        marker.addEventListener('click', function()
        {
            click(marker)
        })

        this.html.appendChild(marker);

        this.markers.push(marker)
    }
    map.AddMarker = f.bind(map)

    f = function()
    {
        this.markers.forEach(elem =>
            {
                const tmp = elem.style.left
                elem.style.left = elem.style.top
                elem.style.top = elem.style.left
            })
    }

    map.onorientationchange = f.bind(map)

    staticMapsInternal.push(map)

    return map
}
function RelativePosition(x,y)
{
    return {x:x, y:y}
}

window.onorientationchange = function()
{ 
    staticMapsInternal.forEach(map => {
        map.onorientationchange()
    })
}