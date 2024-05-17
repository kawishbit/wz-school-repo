namespace LspCertification.Models;

public class DistributorModels
{
    public Guid DistributorId { get; set; }
    public string DistributorCode { get; set; } = string.Empty;
    public string DistributorName { get; set; } = string.Empty;
    public string Address { get; set; } = string.Empty;
    public string EmailAddress { get; set; } = string.Empty;
    public string PhoneNumber { get; set; } = string.Empty;
    public string ContactPerson { get; set; } = string.Empty;
}
public class DistributorCreateRequest
{
    public string DistributorCode { get; set; } = string.Empty;
    public string DistributorName { get; set; } = string.Empty;
    public string Address { get; set; } = string.Empty;
    public string EmailAddress { get; set; } = string.Empty;
    public string PhoneNumber { get; set; } = string.Empty;
    public string ContactPerson { get; set; } = string.Empty;
}

public class DistributorUpdateRequest
{
    public string DistributorCode { get; set; } = string.Empty;
    public string DistributorName { get; set; } = string.Empty;
    public string Address { get; set; } = string.Empty;
    public string EmailAddress { get; set; } = string.Empty;
    public string PhoneNumber { get; set; } = string.Empty;
    public string ContactPerson { get; set; } = string.Empty;
}