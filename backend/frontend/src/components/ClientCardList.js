import ClientCard from "./cards/ClientCard"

const ClientCardList = ({clients, setFormData, onDelete}) => {
    return(
        <>
            {clients.map((client) => (

                <ClientCard key={client.id} client={client} setFormData={setFormData} onDelete={onDelete} />))}
        </>
    );
}

export default ClientCardList;