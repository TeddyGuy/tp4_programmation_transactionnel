import ClientCard from "./ClientCard"

const ClientCardList = ({clients, setFormData}) => {
    return(
        <>
            {clients.map((client) => (

                <ClientCard key={client.id} client={client} setFormData={setFormData} />))}
        </>
    );
}

export default ClientCardList;