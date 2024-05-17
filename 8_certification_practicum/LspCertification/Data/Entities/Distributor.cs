using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LspCertification.Data.Entities;

[Table("Distributors")]
public class Distributor : BaseEntity
{
    [Key] public Guid DistributorId { get; set; } = Guid.NewGuid();
    [Required, MaxLength(6)] public string DistributorCode { get; set; } = string.Empty;
    [MaxLength(128)] public string DistributorName { get; set; } = string.Empty;
    [MaxLength(255)] public string Address { get; set; } = string.Empty;
    [MaxLength(128)] public string EmailAddress { get; set; } = string.Empty;
    [MaxLength(15)] public string PhoneNumber { get; set; } = string.Empty;
    [MaxLength(128)] public string ContactPerson { get; set; } = string.Empty;
    
    public virtual ICollection<Spectacle> Spectacles { get; set; } = new List<Spectacle>();
    public void SetId(Guid id)
    {
        DistributorId = id;
    }
}