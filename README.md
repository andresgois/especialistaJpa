# especialistaJpa

## Relacionamentos

### Tipos
- Muitos para um
- Um para muitos
- Um para um
- Muitos para muitos

#### Muitos pra um

![Muitos pra um](./asserts/muitos_pra_um.png)

![Muitos pra um](./asserts/relacao_n_1.png)

![Muitos pra um](./asserts/relacao_n_1_java.png)

#### Um para muitos

![Um para muitos](./asserts/um_pra_muitos.png)

![Um para muitos](./asserts/relacionamento_um_pra_muitos.png)

![Um para muitos](./asserts/um_pra_muitos_java.png)

#### Um pra um

![Um pra um](./asserts/um_pra_um_desc.png)

![Um pra um](./asserts/um_pra_um_rel.png)

![Um pra um](./asserts/um_pra_um_java.png)

#### Muitos pra Muitos

![Muitos pra Muitos](./asserts/m_pra_m_desc.png)

![Muitos pra Muitos](./asserts/m_pra_m_rel.png)

![Muitos pra Muitos](./asserts/m_pra_m_java.png)


### Mapeamento Bidirecional

> Inda: **List<Categoria> categorias**

![Muitos pra Muitos](./asserts/m_pra_m_java.png)

> Volta: **@ManyToMany(mappedBy= ...)**

### Owner e Non-Owning
- Dono e não dono do mapeamento

> Dono que utiliza **@JoinTable ou @JoinColumn ou quem utiliza o contrário de mappedBy**

> Quem persiste a relação é o *Owner*


### Estratégias para gerar ID
- Hibernate escolhe a forma, ele cria a tabela hibernate_sequence

```
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
```

- Ele gera uma sequence

```
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cat")
@SequenceGenerator(name = "seq_cat", sequenceName = "seq_chave_primary_cat")
private Integer id;
```

- ele cria a tabela hibernate_sequences, ele vai com chave primaria  e o próximo valor

```
@Id
@GeneratedValue(strategy = GenerationType.TABLE, generator = "tabela")
@TableGenerator(name = "tabela", table = "hibernate_sequences",
            pkColumnName = "sequence_name", pkColumnValue = "categoria",
            valueColumnName = "next_val", initialValue = 0, allocationSize = 1)
private Integer id;
```

- auto incremento

```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
```