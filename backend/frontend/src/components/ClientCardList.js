import ClientCard from "./ClientCard"

const ClientCardList = ({clients}) => {
    return(
        <>
            {clients.map((client) => (

                <ClientCard key={client.id} client={client} />))}
        </>
    );
}

export default ClientCardList;