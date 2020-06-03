function PageOpener(url)
{
    return () => {window.location.href = url};
}