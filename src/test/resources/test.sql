INSERT INTO public.plugin (id, nome_plugin, descricao_plugin, data_criacao)
VALUES
		('12345', 'ADMIN', 'ADMINISTRACAO DE INTENS', GETDATE()),
		('1223', 'EXPORT', 'EXPORTACAO DE DADOS', GETDATE()-1);

INSERT INTO public.funcionalidade (id, nome_funcionalidade, descricao_funcionalidade, data_criacao)
VALUES
		('123456', 'INCLUIR', 'INCLUI INTENS', GETDATE()),
		('123457', 'ALTERAR', 'ALTERAR INTENS', GETDATE()),
		('123458', 'VISUALIZAR', 'VISUALIZA INTENS', GETDATE()),
		('123459', 'EXCLUIR', 'EXCLUI INTENS', GETDATE());