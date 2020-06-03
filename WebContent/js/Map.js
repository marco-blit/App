function CreateMap(mapHTML)
{
    map = new google.maps.Map(mapHTML, 
    {
        center: {lat: 44.6888768, lng: 10.6594437},
        zoom: 14
    })

    map.markers = []
    map.AddMarker = AddMarker.bind(map)
    map.userPos = new google.maps.Marker({
        clickable: false,
        icon: 'images/user-position.png',
        shadow: null,
        zIndex: 999,
        map: map
    })
    map.watchId = navigator.geolocation.watchPosition(UpdatePos.bind(map))

    setInterval(CheckProximity.bind(map), 5000)

    return map
}

function CheckProximity()
{
    this.markers.forEach(marker => 
    {
        
    })
}
function UpdatePos(position)
{
    this.userPos.setPosition(
        {
            lat: position.coords.latitude,
            lng: position.coords.longitude
        })
}
function AddMarker(title, pos, click)
{
    var marker = new google.maps.Marker({
        position: pos,
        map: this,
        title: title
    })
    marker.addListener('click', function()
    {
        click(marker)
    })
    this.markers.push(marker)
}

function Marker(latitude, longitude)
{
    return {lat: latitude, lng: longitude}
}